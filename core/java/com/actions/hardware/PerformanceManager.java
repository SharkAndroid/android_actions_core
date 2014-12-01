/*
 * Copyright (C) 2014 Actions-Semi, Inc.
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

	private IPerformanceService mIPerformanceService;
	
	public PerformanceManager() {
			
		mIPerformanceService = IPerformanceService.Stub.asInterface(
                      	ServiceManager.getService("PerformanceService"));
        if (mIPerformanceService == null) {
					Log.e(TAG, "Error. Can not get PerformanceService!");
				}
	}

    public boolean getMaxPerformance()
    {
    	try {
    		return mIPerformanceService.getMaxPerformance();
    	} catch(Exception e) {
    		e.printStackTrace();   		
    	}
    	
    	return false;
    }
    
    public boolean putMaxPerformance()
    {
    	try {
    		return mIPerformanceService.putMaxPerformance();
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	return false;
    }
    
    public boolean singleThreadAccelerate(int pid)
    {
    	try {
    		return mIPerformanceService.singleThreadAccelerate(pid);
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	return false;
    }
	
    public boolean cleanAllVmCaches()
    {
    	try {
    		return mIPerformanceService.cleanAllVmCaches();
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	return false;
    }
	
    public boolean setCpuFreqRange(IBinder who, int min, int max)
    {
    	try {
    		return mIPerformanceService.setCpuFreqRange(who, min, max);
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	return false;
    }
	
    public boolean restoreCpuFreqRange(IBinder who)
    {
    	try {
    		return mIPerformanceService.restoreCpuFreqRange(who);
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	return false;
    }
    
    public boolean enbleAutoAdjustBacklight()
    {
    	try {
    		return mIPerformanceService.enbleAutoAdjustBacklight();
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	return false;
    }
    
    public boolean disableAutoAdjustBacklight()
    {
    	try {
    		return mIPerformanceService.disableAutoAdjustBacklight();
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	return false;
    }
    
    public boolean setAlign()
    {
    	try {
    		return mIPerformanceService.setAlign();
    	} catch(Exception e) {
    		e.printStackTrace();   		
    	}

    	return false;
    }
	
    public boolean clearAlign()
    {
    	try {
    		return mIPerformanceService.clearAlign();
    	} catch(Exception e) {
    		e.printStackTrace();   		
    	}
		
    	return false;
    }
	
    public boolean notifier( int pid)
    {
    	try {
    		return mIPerformanceService.notifier(pid);
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	return false;
    }
	
    public boolean setOpt()
    {
    	try {
    		return mIPerformanceService.setOpt();
    	} catch(Exception e) {
    		e.printStackTrace();   		
    	}
		
    	return false;
    }
	
    public boolean clearOpt()
    {
    	try {
    		return mIPerformanceService.clearOpt();
    	} catch(Exception e) {
    		e.printStackTrace();   		
    	}
		
    	return false;
    }
    
    public boolean getSupport()
    {
    	try {
    		return mIPerformanceService.getSupport();
    	} catch(Exception e) {
    		e.printStackTrace();   		
    	}
		
    	return false;
    }
}