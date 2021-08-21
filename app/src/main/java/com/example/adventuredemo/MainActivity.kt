package com.example.adventuredemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.adventuredemo.component.ProductAdapter
import com.example.adventuredemo.databinding.ActivityMainBinding
import com.example.adventuredemo.network.Product
import com.example.adventuredemo.util.Resource
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mockProduct = listOf(
            Product(
                "iPhone 11 Pro",
                "ชิพ A12X Bionic คือชิพที่ทั้งฉลาดและทรงพลังเหลือเชื่อ โดยมาพร้อม Neural Engine ที่สามารถดำเนินการต่างๆ ได้ถึง 5 ล้านล้านรายการ ต่อวินาที รวมถึงใช้งานการเรียนรู้ ขั้นสูงของระบบ",
                "https://store.storeimages.cdn-apple.com/8756/as-images.apple.com/is/iphone-11-pro-select-2019-family",
                "https://private-18a32-iosadv.apiary-mock.com/iphone"
            ),
            Product(
                "iPad Pro",
                "ระบบสามกล้องที่ปฏิวัติมาใหม่มาพร้อมกับความสามารถมากมาย ที่ถึงจะใหม่แต่รับรองว่าไม่มีอะไรซับซ้อน ในส่วนของแบตเตอรี่ก็ใช้งานได้นานขึ้นแบบก้าวกระโดดอย่างที่ไม่เคยมีมาก่อน ",
                "https://store.storeimages.cdn-apple.com/8756/as-images.apple.com/is/ipad-pro-12-11-select-201810_GEO_TH_LANG_TH",
                "https://private-18a32-iosadv.apiary-mock.com/ipad"
            ),
            Product(
                "Apple Watch",
                "คุณไม่จำเป็นต้องยกข้อมือหรือแตะหน้าจอเพื่อดูเวลา หรือข้อมูลอื่นๆ บนหน้าปัดนาฬิกาอีกต่อไป เพราะวันนี้จอภาพจะไม่มีวันหลับ สิ่งที่คุณต้องทำก็เพียงเหลือบมองเพื่อดูเวลาหรือตัววัดการออกกำลังกายของคุณแค่นั้นเอง",
                "https://res.cloudinary.com/cenergy-innovation-limited-head-office/image/fetch/c_scale,q_70,f_auto,h_740/https://d1dtruvuor2iuy.cloudfront.net/media/catalog/product/a/p/apple_watch_series_6_gps_blue_aluminum_deep_navy_1.jpg",
                "https://private-18a32-iosadv.apiary-mock.com/applewatch"
            ), Product(
                "iPhone 11 Pro",
                "ชิพ A12X Bionic คือชิพที่ทั้งฉลาดและทรงพลังเหลือเชื่อ โดยมาพร้อม Neural Engine ที่สามารถดำเนินการต่างๆ ได้ถึง 5 ล้านล้านรายการ ต่อวินาที รวมถึงใช้งานการเรียนรู้ ขั้นสูงของระบบ",
                "https://store.storeimages.cdn-apple.com/8756/as-images.apple.com/is/iphone-11-pro-select-2019-family",
                "https://private-18a32-iosadv.apiary-mock.com/iphone"
            ),
            Product(
                "iPad Pro",
                "ระบบสามกล้องที่ปฏิวัติมาใหม่มาพร้อมกับความสามารถมากมาย ที่ถึงจะใหม่แต่รับรองว่าไม่มีอะไรซับซ้อน ในส่วนของแบตเตอรี่ก็ใช้งานได้นานขึ้นแบบก้าวกระโดดอย่างที่ไม่เคยมีมาก่อน ",
                "https://store.storeimages.cdn-apple.com/8756/as-images.apple.com/is/ipad-pro-12-11-select-201810_GEO_TH_LANG_TH",
                "https://private-18a32-iosadv.apiary-mock.com/ipad"
            ),
            Product(
                "Apple Watch",
                "คุณไม่จำเป็นต้องยกข้อมือหรือแตะหน้าจอเพื่อดูเวลา หรือข้อมูลอื่นๆ บนหน้าปัดนาฬิกาอีกต่อไป เพราะวันนี้จอภาพจะไม่มีวันหลับ สิ่งที่คุณต้องทำก็เพียงเหลือบมองเพื่อดูเวลาหรือตัววัดการออกกำลังกายของคุณแค่นั้นเอง",
                "https://res.cloudinary.com/cenergy-innovation-limited-head-office/image/fetch/c_scale,q_70,f_auto,h_740/https://d1dtruvuor2iuy.cloudfront.net/media/catalog/product/a/p/apple_watch_series_6_gps_blue_aluminum_deep_navy_1.jpg",
                "https://private-18a32-iosadv.apiary-mock.com/applewatch"
            )
        )
        mainViewModel.getProductsAndBanners()
        mainViewModel.getProductAndBanner.observe(this) { response ->
            when (response) {
                is Resource.Success -> {
//                    hideProgressBar()
                    response.data?.let {
                        Log.i("MYTAG", "came here ${it}")
                        it.banners?.let { it1 -> setUpBanner(it1) }
                        it.products?.let { it1 ->
                            setUpAdapter(it1)
                        }
                    }
                }
                is Resource.Error -> {
//                    hideProgressBar()
                    response.message?.let {
                        Toast.makeText(this, "An error occurred : $it", Toast.LENGTH_LONG)
                            .show()
                    }
                }
                is Resource.Loading -> {
//                    showProgressBar()
                }
            }
        }

    }

    private fun setUpBanner(banners: List<String>) {
        binding.viewPager.adapter = BannerAdapter(this, banners)

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
        }.attach()
    }

    private fun setUpAdapter(productList: List<Product>) {
        val recyclerAdapter = ProductAdapter(productList)

        with(binding.recyclerView) {
            adapter = recyclerAdapter
            layoutManager = object : LinearLayoutManager(context) {
                override fun canScrollVertically(): Boolean {
                    return true
                }
            }
        }
    }

    private inner class BannerAdapter(fa: FragmentActivity, private val banners: List<String>) :
        FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = banners.size

        override fun createFragment(position: Int): Fragment {
            return BannerFragment.getInstance(banners[position])
        }
    }
}