package com.example.a2_semina_assignment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
        loadDatas()
    }
    private fun loadDatas()
    {
        datas.apply {
            add(InstaData(userName = "유나킴1"
                ,img_profile = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fkr.123rf.com%2F%25EC%258A%25A4%25ED%2586%25A1%25EC%2582%25AC%25EC%25A7%2584%2F%25EA%25B0%2595%25EC%2595%2584%25EC%25A7%2580.html&psig=AOvVaw3k1ShZou7PS1EHLoLzdbjm&ust=1587885787644000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCLiey9iFg-kCFQAAAAAdAAAAABAD",
                img_contents = "https://www.google.com/url?sa=i&url=http%3A%2F%2Fwww.hani.co.kr%2Farti%2FPRINT%2F917748.html&psig=AOvVaw3k1ShZou7PS1EHLoLzdbjm&ust=1587885787644000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCLiey9iFg-kCFQAAAAAdAAAAABAP"
            ))
            add(InstaData(userName = "유나킴2"
                ,img_profile = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fkr.123rf.com%2F%25EC%258A%25A4%25ED%2586%25A1%25EC%2582%25AC%25EC%25A7%2584%2F%25EA%25B0%2595%25EC%2595%2584%25EC%25A7%2580.html&psig=AOvVaw3k1ShZou7PS1EHLoLzdbjm&ust=1587885787644000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCLiey9iFg-kCFQAAAAAdAAAAABAD",
                img_contents = "https://www.google.com/url?sa=i&url=http%3A%2F%2Fwww.hani.co.kr%2Farti%2FPRINT%2F917748.html&psig=AOvVaw3k1ShZou7PS1EHLoLzdbjm&ust=1587885787644000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCLiey9iFg-kCFQAAAAAdAAAAABAP"
            ))

            add(InstaData(userName = "유나킴3"
                ,img_profile = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fkr.123rf.com%2F%25EC%258A%25A4%25ED%2586%25A1%25EC%2582%25AC%25EC%25A7%2584%2F%25EA%25B0%2595%25EC%2595%2584%25EC%25A7%2580.html&psig=AOvVaw3k1ShZou7PS1EHLoLzdbjm&ust=1587885787644000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCLiey9iFg-kCFQAAAAAdAAAAABAD",
                img_contents = "https://www.google.com/url?sa=i&url=http%3A%2F%2Fwww.hani.co.kr%2Farti%2FPRINT%2F917748.html&psig=AOvVaw3k1ShZou7PS1EHLoLzdbjm&ust=1587885787644000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCLiey9iFg-kCFQAAAAAdAAAAABAP"
            ))

            add(InstaData(userName = "유나킴4"
                ,img_profile = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fkr.123rf.com%2F%25EC%258A%25A4%25ED%2586%25A1%25EC%2582%25AC%25EC%25A7%2584%2F%25EA%25B0%2595%25EC%2595%2584%25EC%25A7%2580.html&psig=AOvVaw3k1ShZou7PS1EHLoLzdbjm&ust=1587885787644000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCLiey9iFg-kCFQAAAAAdAAAAABAD",
                img_contents = "https://www.google.com/url?sa=i&url=http%3A%2F%2Fwww.hani.co.kr%2Farti%2FPRINT%2F917748.html&psig=AOvVaw3k1ShZou7PS1EHLoLzdbjm&ust=1587885787644000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCLiey9iFg-kCFQAAAAAdAAAAABAP"
            ))

        }

        instaAdapter.datas = datas
        instaAdapter.notifyDataSetChanged()
    }

}
