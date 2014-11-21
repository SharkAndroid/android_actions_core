# Copyright (C) 2008 The Android Open Source Project
# Copyright (C) 2014 SharkAndroid
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_SRC_FILES := \
		$(call all-java-files-under, core)\
		$(call all-java-files-under, services)

LOCAL_MODULE_TAGS := eng optional
LOCAL_MODULE := actions_hardware

LOCAL_MODULE_CLASS := JAVA_LIBRARIES	

# The AIDL component as part of java lib
# ============================================================
# Also build all of the sub-targets under this one: the library's
# associated AIDL code, and a client of the library.
LOCAL_AIDL_INCLUDES +=$(LOCAL_PATH)/core/java
LOCAL_SRC_FILES += \
	core/java/com/actions/hardware/ICableStatusListener.aidl \
	core/java/com/actions/hardware/IDisplayService.aidl\
	core/java/com/actions/hardware/IPerformanceService.aidl

framework_built := $(call java-lib-deps,framework)
LOCAL_PRELINK_MODULE := false 
include $(BUILD_JAVA_LIBRARY)

# The JNI component
# ============================================================
# Also build all of the sub-targets under this one: the library's
# associated JNI code, and a sample client of the library.
include $(CLEAR_VARS)

include $(call all-makefiles-under,$(LOCAL_PATH))