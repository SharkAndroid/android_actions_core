/*
 * Copyright (C) 2012 Actions-Semi, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
 
package com.actions.hardware;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import android.content.Context;
import android.content.Intent;

import com.actions.hardware.IPerformanceService;

public class PerformanceManager{
	private static final String TAG = "PerformanceManager";

	private IPerformanceService mPerformanceService;
	
	public PerformanceManager() {
			
		mPerformanceService = IPerformanceService.Stub.asInterface(
                      	ServiceManager.getService("performanceservice"));
        if (mPerformanceService == null) {
					Log.e(TAG, "Error! can not get PerformanceService!");
				}

	 }
    public boolean getMaxPerformance()
    {
    	try{
    		return mPerformanceService.getMaxPerformance();
    	}catch(Exception e){
    		e.printStackTrace();   		
    	}
    	
    	return false;
    }
    
    public boolean putMaxPerformance()
    {
    	try{
    		return mPerformanceService.putMaxPerformance();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return false;
    }
    
    public boolean singleThreadAccelerate( int pid)
    {
    	try{
    		return mPerformanceService.singleThreadAccelerate(pid);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return false;
    }
	
    public boolean cleanAllVmCaches()
    {
    	try{
    		return mPerformanceService.cleanAllVmCaches();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return false;
    }
	
    public boolean setCpuFreqRange(IBinder who, int min, int max)
    {
    	try{
    		return mPerformanceService.setCpuFreqRange(who, min, max);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return false;
    }
	
    public boolean restoreCpuFreqRange(IBinder who)
    {
    	try{
    		return mPerformanceService.restoreCpuFreqRange(who);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return false;
    }
    
    public boolean enbleAutoAdjustBacklight()
    {
    	try{
    		return mPerformanceService.enbleAutoAdjustBacklight();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return false;
    }
    
    public boolean disableAutoAdjustBacklight()
    {
    	try{
    		return mPerformanceService.disableAutoAdjustBacklight();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return false;
    }
    
    public boolean setAlign()
    {
    	try{
    		return mPerformanceService.setAlign();
    	}catch(Exception e){
    		e.printStackTrace();   		
    	}
    	return false;
    }
    	public boolean clearAlign()
    {
    	try{
    		return mPerformanceService.clearAlign();
    	}catch(Exception e){
    		e.printStackTrace();   		
    	}
    	return false;
    }
	
    public boolean notifier( int pid)
    {
    	try{
    		return mPerformanceService.notifier(pid);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return false;
    }
	
    public boolean setOpt()
    {
    	try{
    		return mPerformanceService.setOpt();
    	}catch(Exception e){
    		e.printStackTrace();   		
    	}
    	return false;
    }
	
    public boolean clearOpt()
    {
    	try{
    		return mPerformanceService.clearOpt();
    	}catch(Exception e){
    		e.printStackTrace();   		
    	}
    	return false;
    }
    
    public boolean getSupport()
    {
    	try{
    		return mPerformanceService.getSupport();
    	}catch(Exception e){
    		e.printStackTrace();   		
    	}
    	return false;
    }
}