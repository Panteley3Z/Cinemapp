package ru.devzerkpant.cinemapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var filmsAdapter: FilmListRecyclerAdapter

    private val cinemaDataBase = listOf(
        Film(R.drawable.cover_back_future, "Back to the Future", "Безумный ученый и 17-летний оболтус тестируют машину времени и наводят шороху в 1950-х. Классика кинофантастики"),
        Film(R.drawable.cover_dark_knight,"The Dark Knight",  "У Бэтмена появляется новый враг — философ-террорист Джокер. Кинокомикс, который вывел жанр на новый уровень"),
        Film(R.drawable.cover_forrest_gump,"Forrest Gump",  "Полувековая история США глазами чудака из Алабамы. Абсолютная классика Роберта Земекиса с Томом Хэнксом"),
        Film(R.drawable.cover_inception,"Inception",  "Кобб – талантливый вор, лучший из лучших в опасном искусстве извлечения: он крадет ценные секреты из глубин подсознания во время сна, когда человеческий разум наиболее уязвим."),
        Film(R.drawable.cover_green_mile,"The Green Mile",  "В тюрьме для смертников появляется заключенный с божественным даром. Мистическая драма по роману Стивена Кинга"),
        Film(R.drawable.cover_interstellar,"Interstellar",  "Когда засуха, пыльные бури и вымирание растений приводят человечество к продовольственному кризису, коллектив исследователей и учёных отправляется сквозь червоточину (которая предположительно соединяет области пространства-времени через большое расстояние) в путешествие, чтобы превзойти прежние ограничения для космических путешествий человека и найти планету с подходящими для человечества условиями."),
        Film(R.drawable.cover_pulp_fiction,"Pulp Fiction",  "Несколько связанных историй из жизни бандитов. Шедевр Квентина Тарантино, который изменил мировое кино"),
        Film(R.drawable.cover_schindlers_list,"Schindler's List",  "История немецкого промышленника, спасшего тысячи жизней во время Холокоста. Драма Стивена Спилберга"),
        Film(R.drawable.cover_shawshank_redemption,"The Shawshank Redemption",  "Бухгалтер Энди Дюфрейн обвинён в убийстве собственной жены и её любовника. Оказавшись в тюрьме под названием Шоушенк, он сталкивается с жестокостью и беззаконием, царящими по обе стороны решётки. Каждый, кто попадает в эти стены, становится их рабом до конца жизни."),
        Film(R.drawable.cover_intouchables,"Intouchables",  "Пострадав в результате несчастного случая, богатый аристократ Филипп нанимает в помощники человека, который менее всего подходит для этой работы, – молодого жителя предместья Дрисса, только что освободившегося из тюрьмы. Несмотря на то, что Филипп прикован к инвалидному креслу, Дриссу удается привнести в размеренную жизнь аристократа дух приключений.")
        )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        main_rv.apply {
            filmsAdapter = FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener {
                override fun click(film: Film) {
                    (requireActivity() as MainActivity).launchDetailsFragment(film)
                }
            })
            adapter = filmsAdapter
            layoutManager = LinearLayoutManager(requireContext())

        }
        filmsAdapter.addItems(cinemaDataBase)
    }
}