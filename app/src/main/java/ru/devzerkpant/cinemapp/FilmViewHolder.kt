package ru.devzerkpant.cinemapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.film_card.view.*

class FilmViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val cover = itemView.film_cover
    private val title = itemView.title
    private val description = itemView.description

    fun bind(film: Film) {
        cover.setImageResource(film.cover)
        title.text = film.title
        description.text = film.description
    }
}