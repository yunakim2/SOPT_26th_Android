package com.example.sopt_semina_assignment.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sopt_semina_assignment.R
import com.example.sopt_semina_assignment.data.InstaData
import com.example.sopt_semina_assignment.ui.insta.InstaAdapter
import com.example.sopt_semina_assignment.util.VerticalItemDecorator
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    lateinit var instaAdapter: InstaAdapter
    val datas = mutableListOf<InstaData>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        instaAdapter  = InstaAdapter(view.context)
        home_recycler_view.adapter = instaAdapter
        home_recycler_view.layoutManager = LinearLayoutManager(view.context,RecyclerView.VERTICAL,false)
       // home_recycler_view.addItemDecoration(HorizontalItemDecorator(24))
        home_recycler_view.addItemDecoration(VerticalItemDecorator(28))
        loadDatas()
    }
    private fun loadDatas()
    {
        datas.apply {
            add(InstaData(userName = "유나킴1"
                ,img_profile = "https://pbs.twimg.com/profile_images/1181902209698582528/PVU-fj8z_400x400.jpg",
                img_contents = "https://pds.joins.com/service/ssully/pd/2020/01/23/2020012311225987447.jpg"))
            add(InstaData(userName = "유나킴2"
                ,img_profile = "https://pbs.twimg.com/profile_images/1181902209698582528/PVU-fj8z_400x400.jpg",
                img_contents = "https://pds.joins.com/service/ssully/pd/2020/01/23/2020012311225987447.jpg"))
            add(InstaData(userName = "유나킴3"
                ,img_profile = "https://pbs.twimg.com/profile_images/1181902209698582528/PVU-fj8z_400x400.jpg",
                img_contents = "https://pds.joins.com/service/ssully/pd/2020/01/23/2020012311225987447.jpg"))
            add(InstaData(userName = "유나킴4"
                ,img_profile = "https://pbs.twimg.com/profile_images/1181902209698582528/PVU-fj8z_400x400.jpg",
                img_contents = "https://pds.joins.com/service/ssully/pd/2020/01/23/2020012311225987447.jpg"))

        }

        instaAdapter.datas = datas
        instaAdapter.notifyDataSetChanged()
    }

}
