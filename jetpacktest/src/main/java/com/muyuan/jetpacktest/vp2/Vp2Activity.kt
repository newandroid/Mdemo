package com.muyuan.jetpacktest.vp2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.muyuan.jetpacktest.R
import kotlinx.android.synthetic.main.activity_vp2.*

private const val ARG_OBJECT = "object"

class Vp2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vp2)
        initVp2()
    }
    fun initVp2(){
        val collectionDemoFragment = CollectionDemoFragment();
        val beginTransaction = supportFragmentManager.beginTransaction()
        beginTransaction.add(R.id.containerRoot, collectionDemoFragment)
        beginTransaction.show(collectionDemoFragment)
        beginTransaction.commit()
    }

    class CollectionDemoFragment : Fragment() {
        // When requested, this adapter returns a DemoObjectFragment,
        // representing an object in the collection.
        private lateinit var demoCollectionAdapter: DemoCollectionAdapter
        private lateinit var viewPager: ViewPager2

        override fun onCreateView(
                inflater: LayoutInflater,
                container: ViewGroup?,
                savedInstanceState: Bundle?
        ): View? {
            return inflater.inflate(R.layout.collection_demo, container, false)
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            demoCollectionAdapter = DemoCollectionAdapter(this)
            viewPager = view.findViewById(R.id.pager)
            viewPager.adapter = demoCollectionAdapter
            val tabLayout: TabLayout = view.findViewById(R.id.tab_layout)
            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                tab.text = "${(position + 1)}"
            }.attach()
        }
    }

    class DemoCollectionAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

        override fun getItemCount(): Int = 10

        override fun createFragment(position: Int): Fragment {
            // Return a NEW fragment instance in createFragment(int)
            val fragment = DemoObjectFragment()
            fragment.arguments = Bundle().apply {
                // Our object is just an integer :-P
                putInt(ARG_OBJECT, position + 1)
            }
            return fragment
        }
    }


    // Instances of this class are fragments representing a single
// object in our collection.
    class DemoObjectFragment : Fragment() {

        override fun onCreateView(
                inflater: LayoutInflater,
                container: ViewGroup?,
                savedInstanceState: Bundle?
        ): View {
            return inflater.inflate(R.layout.fragment_collection_object, container, false)
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            arguments?.takeIf { it.containsKey(ARG_OBJECT) }?.apply {
                val textView: TextView = view.findViewById(android.R.id.text1)
                textView.text = getInt(ARG_OBJECT).toString()
            }
        }
    }
}
