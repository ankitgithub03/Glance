# Glance

**Project:**   `Maven`

### Directory Structure
```
+-- src
	+-- main
	  +-- java
	  +-- resources
		+-- logFile.txt
	+-- test
	  +-- java
+-- pom.xml
```

### How to run
  - There is java class at "src/test/java/LogForPID.java".
  - check file name and pid to run the code


### Output is:
```

FATAL EXCEPTION
=================

Exception Message| # of Occurrences
java.lang.IllegalStateException: Can not perform this action after onSaveInstanceState |2
java.lang.OutOfMemoryError: OutOfMemoryError thrown while trying to throw OutOfMemoryError; no stack trace available |1


Stacktrace:
==============

#1) java.lang.IllegalStateException: Can not perform this action after onSaveInstanceState
	at android.support.v4.app.FragmentManagerImpl.checkStateLoss(Unknown Source:10)
	at android.support.v4.app.FragmentManagerImpl.enqueueAction(Unknown Source:2)
	at android.support.v4.app.BackStackRecord.a(Unknown Source:78)
	at android.support.v4.app.BackStackRecord.commit(Unknown Source:1)
	at glance.ui.sdk.activity.GlanceHomeActivity.showBingeContainer(Unknown Source:19)
	at glance.ui.sdk.activity.GlanceHomeActivity.e(Unknown Source:0)
	at glance.ui.sdk.activity.GlanceHomeActivity$3.onTabSelected(Unknown Source:30)
	at android.support.design.widget.TabLayout.dispatchTabSelected(Unknown Source:19)
	at android.support.design.widget.TabLayout.a(Unknown Source:55)
	at android.support.design.widget.TabLayout.a(Unknown Source:1)
	at android.support.design.widget.TabLayout$Tab.select(Unknown Source:14)
	at android.support.design.widget.TabLayout$TabView.performClick(Unknown Source:16)
	at android.view.View.performClickInternal(View.java:6585)
	at android.view.View.access$3100(View.java:785)
	at android.view.View$PerformClick.run(View.java:25921)
	at android.os.Handler.handleCallback(Handler.java:873)
	at android.os.Handler.dispatchMessage(Handler.java:99)
	at android.os.Looper.loop(Looper.java:201)
	at android.app.ActivityThread.main(ActivityThread.java:6810)
	at java.lang.reflect.Method.invoke(Native Method)
	at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:547)
	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:873)


#2) java.lang.OutOfMemoryError: OutOfMemoryError thrown while trying to throw OutOfMemoryError; no stack trace available




Errors
==============

Error Message| # of Occurrences
 FATAL EXCEPTION: Timer-16 | 1
 Failed to find provider info for com.miui.systemui.keyguard.wallpaper | 1
 java.lang.OutOfMemoryError: OutOfMemoryError thrown while trying to throw OutOfMemoryError; no stack trace available | 2
 Uncaught exception thrown by finalizer | 1
 FATAL EXCEPTION: main | 2
 Process: com.miui.android.fashiongallery, PID: 4667 | 3
 failed to kill 1 processes for processgroup 4667 | 1
 java.lang.IllegalStateException: Can not perform this action after onSaveInstanceState | 2
 *** Uncaught exception returned from Java call! | 2
 getDeviceIdjava.lang.SecurityException: getDeviceId: Neither user 10178 nor current process has android.permission.READ_PHONE_STATE. | 1


Matching Strings =>WARNING
==============

Matching String | # of Occurrences
 JNI WARNING: java.lang.OutOfMemoryError thrown while calling printStackTrace | 3


Matching Strings =>OOM
==============

Matching String | # of Occurrences
 Throwing OutOfMemoryError "Failed to allocate a 16 byte allocation with 0 free bytes and -2MB until OOM" | 1
 Throwing OutOfMemoryError "Failed to allocate a 32 byte allocation with 0 free bytes and -2MB until OOM" | 1
 Throwing OutOfMemoryError "Failed to allocate a 28 byte allocation with 0 free bytes and -2MB until OOM" | 2
 Throwing OutOfMemoryError "Failed to allocate a 43 byte allocation with 0 free bytes and -2MB until OOM" | 2
 Throwing OutOfMemoryError "Failed to allocate a 56 byte allocation with 0 free bytes and -2MB until OOM" | 1
 Throwing OutOfMemoryError "Failed to allocate a 8204 byte allocation with 0 free bytes and -2MB until OOM" | 2
 Throwing OutOfMemoryError "Failed to allocate a 128 byte allocation with 0 free bytes and -2MB until OOM" | 1
 Throwing OutOfMemoryError "Failed to allocate a 28 byte allocation with 0 free bytes and -2MB until OOM" (recursive case) | 16
 Throwing OutOfMemoryError "Failed to allocate a 12 byte allocation with 0 free bytes and -2MB until OOM" | 4
 Throwing OutOfMemoryError "Failed to allocate a 24 byte allocation with 0 free bytes and -2MB until OOM" | 2


Matching Strings =>OutOfMemoryError
==============

Matching String | # of Occurrences
 Throwing OutOfMemoryError "Failed to allocate a 16 byte allocation with 0 free bytes and -2MB until OOM" | 1
 Throwing OutOfMemoryError "Failed to allocate a 32 byte allocation with 0 free bytes and -2MB until OOM" | 1
 Throwing OutOfMemoryError "Failed to allocate a 28 byte allocation with 0 free bytes and -2MB until OOM" | 2
 java.lang.OutOfMemoryError: OutOfMemoryError thrown while trying to throw OutOfMemoryError; no stack trace available | 3
 Throwing OutOfMemoryError "Failed to allocate a 43 byte allocation with 0 free bytes and -2MB until OOM" | 2
 Throwing OutOfMemoryError "Failed to allocate a 56 byte allocation with 0 free bytes and -2MB until OOM" | 1
 Throwing OutOfMemoryError "Failed to allocate a 8204 byte allocation with 0 free bytes and -2MB until OOM" | 2
 Throwing OutOfMemoryError "Failed to allocate a 128 byte allocation with 0 free bytes and -2MB until OOM" | 1
 Throwing OutOfMemoryError "Failed to allocate a 28 byte allocation with 0 free bytes and -2MB until OOM" (recursive case) | 16
 [4667,0,com.miui.android.fashiongallery,954744390,java.lang.OutOfMemoryError,OutOfMemoryError thrown while trying to throw OutOfMemoryError; no stack trace available,unknown,0] | 1
 JNI WARNING: java.lang.OutOfMemoryError thrown while calling printStackTrace | 3
 Throwing OutOfMemoryError "Failed to allocate a 12 byte allocation with 0 free bytes and -2MB until OOM" | 4
 Throwing OutOfMemoryError "Failed to allocate a 24 byte allocation with 0 free bytes and -2MB until OOM" | 2

```