package com.example.anime;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anime.databinding.FragmentMainBinding;

import java.util.ArrayList;

public class MainFragment extends Fragment implements OnItemClick {

    AnimeAdapter animeAdapter;
    FragmentMainBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<AnimeModel> list = new ArrayList<>();
        list.add(new AnimeModel("Bungou Stray Dogs", "Atsushi", 36));
        list.add(new AnimeModel("Fairy Tail", "Natsu", 328));
        list.add(new AnimeModel("One Piece", "Luffy", 1025));
        list.add(new AnimeModel("SAO", "Kirito", 73));
        list.add(new AnimeModel("Дорога юности", "Мабучи", 24));
        list.add(new AnimeModel("Сдутсовет: горничная","Усуи", 24));
        list.add(new AnimeModel("Код Гиас", "Лелуш", 50));
        list.add(new AnimeModel("Борец Сома", "Сома", 85));
        list.add(new AnimeModel("Хантер", "Рудеус", 148));

        animeAdapter = new AnimeAdapter(list, this);
        binding.recyclerAnime.setAdapter(animeAdapter);
    }

    @Override
    public void onClick(AnimeModel animeModel) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("key", animeModel);
        DetailFragment detailFragment = new DetailFragment();
        detailFragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, detailFragment).commit();
    }
}