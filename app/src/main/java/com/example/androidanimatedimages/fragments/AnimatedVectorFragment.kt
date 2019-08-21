package com.example.androidanimatedimages.fragments

import android.content.Context
import android.graphics.drawable.Animatable
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat


import kotlinx.android.synthetic.main.fragment_animated_vector.*
import android.os.Handler



// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [AnimatedVectorFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [AnimatedVectorFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AnimatedVectorFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(com.example.androidanimatedimages.R.layout.fragment_animated_vector, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val ghostToSkull = ContextCompat.getDrawable(view.context, com.example.androidanimatedimages.R.drawable.avd_ghost_to_skull)
        val skullToGhost = ContextCompat.getDrawable(view.context, com.example.androidanimatedimages.R.drawable.avd_skull_to_ghost)
        iv_av.setImageDrawable(ghostToSkull)
        var check = 0
        val handler = Handler()
        iv_av.setOnClickListener{
            if (check==0) {
                (ghostToSkull as Animatable).start()

                handler.postDelayed({iv_av.setImageDrawable(skullToGhost)}, 1000)

                check++

            }
            else{
                (skullToGhost as Animatable).start()
                handler.postDelayed({iv_av.setImageDrawable(ghostToSkull)}, 1000)

                check=0
            }

        }
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AnimatedVectorFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AnimatedVectorFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
