package com.cocodealight

import android.Manifest
import android.app.Activity
import android.os.Bundle
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import kr.co.ksystem.companity.FlexFragment
import kr.co.ksystem.companity.dto.CustomAction
import kr.co.ksystem.companity.utils.Utils

class MainActivity : AppCompatActivity(), FlexFragment.WebViewBack {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 링크 파라미터 처리
        val linkParam = Utils.getFlexLinkParams(intent)
        startAppPage(linkParam)

        // 뒤로가기 처리
        onBackPressedDispatcher.addCallback(this) {
            val frag = supportFragmentManager.findFragmentById(R.id.fragment)
            if (frag is FlexFragment) {
                frag.moveToBackStep()
            } else {
                finish()
            }
        }
    }

    private fun startAppPage(linkParam: String?) {
        val flexFragment = MyFrag()
        val bundle = Bundle()

        if (linkParam != null) {
            bundle.putString("linkParam", linkParam)
        }
        bundle.putString("appId", "codealight")
        flexFragment.setArguments(bundle)

        val fragmentManager: FragmentManager = supportFragmentManager
        fragmentManager.beginTransaction()
            .setCustomAnimations(
                kr.co.ksystem.companity.R.animator.activity_slide_up,
                kr.co.ksystem.companity.R.animator.exit_from_bottom,
                kr.co.ksystem.companity.R.animator.exit_from_bottom,
                kr.co.ksystem.companity.R.animator.enter_from_bottom
            )
            .replace(R.id.fragment, flexFragment)
            .commit()
    }

    // WebViewBack 인터페이스 구현
    override fun onWebViewBackPressed() {
        finish()
    }

    override fun onLoadScenarioFail() {
        TODO("Not yet implemented")
    }

    override fun onWebLogout() {
        TODO("Not yet implemented")
    }

    override fun onWebNoSession() {
        TODO("Not yet implemented")
    }
}

// Custom Fragment 구현
class MyFrag : FlexFragment() {
    override fun onCustomAction(customAction: CustomAction?, passResultToWeb: PassResultToWeb?) {
        TODO("Not yet implemented")
    }
}