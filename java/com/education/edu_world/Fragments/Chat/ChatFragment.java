package com.education.edu_world.Fragments.Chat;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.education.edu_world.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


public class ChatFragment extends Fragment {

    public View parentView;
    private ViewPager view_pager;
    private TabLayout tab_layout;

    private ImageButton btnAddBusiness, btnAddAdmin, btnLogOut;
    private ImageView imgProfile;
    private TextView tvUserName, tvProfession, tvLocation;

    String profileId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.fragment_chat, container, false);

        initComponent();


        // Inflate the layout for this fragment
        return parentView;
    }

    private void initComponent() {
        btnAddBusiness = parentView.findViewById(R.id.add_company);
        btnAddAdmin = parentView.findViewById(R.id.add_admin);
        btnLogOut = parentView.findViewById(R.id.log_out);
        imgProfile = parentView.findViewById(R.id.profile_image);
        tvUserName = parentView.findViewById(R.id.Username_surname);
        tvProfession = parentView.findViewById(R.id.profession);

        tvLocation = parentView.findViewById(R.id.tv_location);

        view_pager = (ViewPager) parentView.findViewById(R.id.view_pager);


        tab_layout = (TabLayout) parentView.findViewById(R.id.tab_layout);
        tab_layout.setupWithViewPager(view_pager);

        /*firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        SharedPreferences prefs = getContext().getSharedPreferences("PREFS", MODE_PRIVATE);
        profileId = prefs.getString("userId", "none");*/
        profileInformation();


        btnAddBusiness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent intent = new Intent(getContext(), CompanyRegActivity.class);
                startActivity(intent);*/
            }
        });

        btnAddAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent(getContext(), AdminRegistrationActivity.class);
                startActivity(intent);*/
            }
        });

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //signOut();

            }
        });


        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getChildFragmentManager());


        adapter.addFragment(MessageFragment.newInstance(), "CHATS");
        adapter.addFragment(GroupsFragment.newInstance(), "GROUPS");

    }

    private void profileInformation() {

        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getChildFragmentManager());


        adapter.addFragment(MessageFragment.newInstance(), "CHATS");
        adapter.addFragment(GroupsFragment.newInstance(), "GROUPS");



    }

    private static class SectionsPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public SectionsPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }




}