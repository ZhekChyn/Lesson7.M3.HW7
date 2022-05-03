package com.geektech.lesson7m3hw7

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.geektech.lesson7m3hw7.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(LayoutInflater.from(requireContext()), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val lesson = Lesson()
        super.onViewCreated(view, savedInstanceState)
        binding.addLesson.setOnClickListener {
            if (binding.lessonName.text.isNotEmpty()){
                val bundle = Bundle()
                bundle.putSerializable("lesson", lesson)
                val lessonsFragment = LessonsFragment()
                lessonsFragment.arguments = bundle
                requireActivity().replaceFragment(LessonsFragment())
                lesson.lesson = binding.lessonName.text.toString()
            }else{
                showToast("Name field cannot be empty!")
            }
        }

        binding.lessonBcg.setOnClickListener {
            val alertDialogBuilder = AlertDialog.Builder(requireContext())
            alertDialogBuilder.setTitle("Choose Background")
            alertDialogBuilder.setItems(R.array.backgrounds
            ) { p0, pos ->
                when (pos){
                    0 -> {
                        binding.lessonBcg.setText(getString(R.string.red))
                        lesson.color = R.color.red
                    }
                    1 -> {
                        binding.lessonBcg.setText(getString(R.string.orange))
                        lesson.color = R.color.orange
                    }
                    2 -> {
                        binding.lessonBcg.setText(getString(R.string.blue))
                        lesson.color = R.color.blue
                    }
                }
            }

            alertDialogBuilder.create().show()
        }
        binding.lessonImage.setOnClickListener {
            var url = ""
            val alertDialogBuilder = AlertDialog.Builder(requireContext())
            alertDialogBuilder.setTitle("Choose Image")
            alertDialogBuilder.setItems(R.array.images
            ) { p0, pos ->
                when (pos){
                    0 -> {
                        url = "https://upload.wikimedia.org/wikipedia/commons/c/c3/Deus_mathematics.png"
                    }
                    1 -> {
                        url = "https://www.pngall.com/wp-content/uploads/9/History-Book.png"
                    }
                    2 -> {
                        url = "https://www.pinclipart.com/picdir/middle/522-5228047_transparent-biology-clipart-microbiology-png.png"
                    }
                }
                lesson.image = url
                binding.lessonImage.setText(url)
            }

            alertDialogBuilder.create().show()
        }
    }
}