package com.architect.kmpessentials.email.delegates

import com.architect.kmpessentials.mainThread.KmpMainThread
import platform.Foundation.NSError
import platform.MessageUI.MFMailComposeResult
import platform.MessageUI.MFMailComposeViewController
import platform.MessageUI.MFMailComposeViewControllerDelegateProtocol
import platform.darwin.NSObject

internal class EmailReceipientDelegate(val mailController: MFMailComposeViewController) : NSObject(), MFMailComposeViewControllerDelegateProtocol{

    override fun mailComposeController(
        controller: MFMailComposeViewController,
        didFinishWithResult: MFMailComposeResult,
        error: NSError?
    ) {
        KmpMainThread.runViaMainThread {
            mailController.dismissViewControllerAnimated(true, null)
        }
    }
}