import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    beerType: ['Pilsner', 'Stout', 'Ale', 'IPA', 'Porter', 'Wheat', 'Special'],
    breweryList: [],
    tempPhotoList: [
      '@/assets/barPhotos/76e5a972057f2e7075aeb2272bab4898.jpg',
      '@/assets/barPhotos/36254911514_62b4959f4a_h.png',
      '@/assets/barPhotos/DESTIHL-Brewery-Interior_1200x800-1024x683.png',
      '@/assets/barPhotos/eris_nicholasjamesphoto_09_39808629561_o_c168c150-45e3-49d3-a370-abac9254b31b.png'
    ],
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },
    SET_BREWERIES(state, data) {
      state.breweryList = data;
    }

  }
})
