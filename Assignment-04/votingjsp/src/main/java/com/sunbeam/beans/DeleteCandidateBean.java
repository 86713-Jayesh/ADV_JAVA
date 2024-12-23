package com.sunbeam.beans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;

public class DeleteCandidateBean {
	private int id;
	
	private String message;
	
	
	public DeleteCandidateBean() {
		
	}
	
	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getMessage() {
		return message;
	}




	public void setMessage(String message) {
		this.message = message;
	}




	public void deleteCandidate() {
		try(CandidateDao candDao = new CandidateDaoImpl()) {
		
			int count = candDao.deleteById(id);
			this.message = "Candidate Deleted" + count;
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
}