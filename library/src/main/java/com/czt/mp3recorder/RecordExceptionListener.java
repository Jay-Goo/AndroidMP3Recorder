package com.czt.mp3recorder;



/**
 * ================================================
 * 作    者：JayGoo
 * 版    本：
 * 创建日期：2017/7/18
 * 描    述:ExceptionListener
 *  Attention: This interface may be not run on UI Thread !
 * ================================================
 */
public interface RecordExceptionListener {
    void onError(Throwable e);
}

