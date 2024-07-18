package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "transaction_history")
@AllArgsConstructor
@NoArgsConstructor
public class TransactionHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "transaction_id", nullable = false)
    private String transactionId;

    @Column(name = "account", nullable = false)
    private String account;

    @Column(name = "in_debt", nullable = false)
    private Double inDebt;

    @Column(name = "have", nullable = false)
    private Double have;

    @Column(name = "time", nullable = false)
    private LocalDateTime time;

	public Long getId() {
		return id;
	}
	
	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Double getInDebt() {
		return inDebt;
	}

	public void setInDebt(Double inDebt) {
		this.inDebt = inDebt;
	}

	public Double getHave() {
		return have;
	}

	public void setHave(Double have) {
		this.have = have;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

    

}