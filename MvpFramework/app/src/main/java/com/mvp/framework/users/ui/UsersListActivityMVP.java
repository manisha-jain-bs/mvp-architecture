package com.mvp.framework.users.ui;

import com.mvp.framework.users.data.ViewModel;

import rx.Observable;

public interface UsersListActivityMVP {

    interface View {

        void updateData(ViewModel viewModel);

        void showSnackbar(String s);
    }

    interface Presenter {

        void loadData();

        void rxUnsubscribe();

        void setView(UsersListActivityMVP.View view);
    }

    interface Model {

        Observable<ViewModel> result();
    }
}
