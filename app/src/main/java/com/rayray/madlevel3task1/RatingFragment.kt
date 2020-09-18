package com.rayray.madlevel3task1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_rating.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class RatingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rating, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_to_summary.setOnClickListener {
            navigateToSummary()
        }

        showRandomAssessableGame()
    }

    private fun navigateToSummary() {
        val ARGS = Bundle()
        ARGS.putFloat(ARG_GAME_RATING, ratingBar.rating)
        ARGS.putString(ARG_GAME_NAME, tvGameTitle.text.toString())

        findNavController().navigate(R.id.action_ratingFragment_to_summaryFragment, ARGS)
    }

    private fun showRandomAssessableGame() {
        val RANDOM_GAME =
            listOf("Grand Theft Auto 5", "Rocket League", "The Last of Us Part II").random()

        tvGameTitle.text = RANDOM_GAME

    }
}