package com.example.samsungsettingsreplica

import android.os.Bundle
import android.view.View
import androidx.preference.PreferenceFragmentCompat
// import androidx.recyclerview.widget.SeslRoundedCorner <-- Don't import this yet if it's red

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Get the list controller
        val list = listView

        // 2. THE ONE UI MAGIC (Temporarily Disabled)
        // list.addItemDecoration(
        //    androidx.recyclerview.widget.SeslRoundedCorner(requireContext())
        // )

        // 3. Remove standard lines
        setDivider(null)
    }
}