#
# Copyright (C) 2014 Actions-Semi, Inc.
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

# This makefile supplies the rules for building a library of JNI code for
# use by our example platform shared library.

LOCAL_PATH:= $(call my-dir)
include $(CLEAR_VARS)

# [optional, user, eng] 
# eng = required
# optinal = no install on target
LOCAL_MODULE_TAGS := eng optional

# This is the target being built.
LOCAL_MODULE:= libactions_runtime

# Target install path.
LOCAL_MODULE_PATH := $(TARGET_OUT_SHARED_LIBRARIES)

# All of the source files that we will compile.
LOCAL_SRC_FILES:= \
    com_actions_server_DisplayService.cpp \
	DisplayParameters.cpp \
	onload.cpp

# All of the shared libraries we link against.
LOCAL_SHARED_LIBRARIES := \
	libandroid_runtime \
	libnativehelper \
	libcutils \
	libutils \
	libbinder \
	libhardware

# Also need the JNI headers.
base := $(LOCAL_PATH)/../..
LOCAL_C_INCLUDES += \
	$(JNI_H_INCLUDE) \
	actions_hardware/actions/hardware/include/ \
	$(base)/include 

# No specia compiler flags.
LOCAL_CFLAGS +=-DLOG_TAG=\"libactions_runtime\"
# Don't prelink this library.  For more efficient code, you may want
# to add this library to the prelink map and set this to true.
LOCAL_PRELINK_MODULE := false

include $(BUILD_SHARED_LIBRARY)