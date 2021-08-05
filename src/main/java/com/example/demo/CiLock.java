package com.example.demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.Getter;

@Service("ciLock")
@Getter
public class CiLock {
	
	@Value("${lock.timeout:3000}")
	private long timeout;
	
	protected final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	protected final Lock readLock = lock.readLock();
	protected final Lock writeLock = lock.writeLock();
	
	public boolean readLock() {
		try {return readLock.tryLock(timeout, TimeUnit.MILLISECONDS);} 
		catch (InterruptedException e) {return false;}
	}
	
	public boolean writeLock() {
		try { return writeLock.tryLock(timeout, TimeUnit.MILLISECONDS); } 
		catch (InterruptedException e) { return false; }
	}
	
	public void readUnLock() {readLock.unlock();}
	public void writeUnLock() {writeLock.unlock();}
	
	
}
