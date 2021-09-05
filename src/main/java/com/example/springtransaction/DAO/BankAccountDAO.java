package com.example.springtransaction.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;

import com.example.springtransaction.entity.BankAccount;
import com.example.springtransaction.exception.BankTransactionException;
import com.example.springtransaction.model.BankAccountInfo;

@Repository
public class BankAccountDAO {
	
	@Autowired
	private EntityManager entityManager;
	
	public BankAccountDAO() {
		
	}
	public BankAccount findById(Long id) {
		return this.entityManager.find(BankAccount.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<BankAccountInfo> listBankAccountInfo(){
		String sql = "Select new " + BankAccountInfo.class.getName() + "(e.id,e.full_name,e.BALANCE)"
				+ " from " + BankAccount.class.getName() + " e ";
		Query query = entityManager.createQuery(sql, BankAccountInfo.class);
		return query.getResultList();
	}
	
	// MANDATORY: Bat buoc phair cos Transactional da duoc taoj truoc do
		//lấy mã tài khoản và xét chuyển tiền
	// nếu không tìm thấy tài khoản thì hiển thị ra tài khoản đó không tồn tài 
	@Transactional(propagation = Propagation.MANDATORY)
	public void addMount(Long id, double amonut) throws BankTransactionException {
		BankAccount account = this.findById(id);
		if(account == null) {
			throw new BankTransactionException("tài khoản không tồn tại" + id);
		}
		double newBalance = account.getBALANCE() + amonut;
		if(account.getBALANCE() + amonut < 0) {
			throw new BankTransactionException(
					"the money in the account '" + id + "' is the not enough (" + account.getBALANCE() + ")");
		}
		account.setBALANCE(newBalance);
	}
	@Transactional(propagation = Propagation.REQUIRES_NEW,
			rollbackFor = BankTransactionException.class)
	public void sendMoney(Long fromAccountId, Long toAccountId, Double amount) throws BankTransactionException {
		// TODO Auto-generated method stub
		addMount(toAccountId, amount);
		addMount(fromAccountId, -amount);
		
		
		
	}

}
