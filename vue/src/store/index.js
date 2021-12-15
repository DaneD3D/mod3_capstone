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

if (currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}
import { getByNoiseLevel, getByMoneyLevel, getByKeyword, getById } from "@/store/filterMethods"

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    activeBreweryId: 0,
    activeBrewery: {},
    beerType: ['Pilsner', 'Stout', 'Ale', 'IPA', 'Porter', 'Wheat', 'Special', 'Belgian'],
    breweryList: [],
    moneyLevel: 0,
    noiseLevel: 0,
    keywordTerm: ''
  },
  getters: {
    filteredList: state => {
      return getByNoiseLevel(state.noiseLevel, getByMoneyLevel(state.moneyLevel, getByKeyword(state.keywordTerm, state.breweryList)))
    }
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user', JSON.stringify(user));
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
    },
    SET_ACTIVE_BREWERY(state, breweryID){
      state.activeBreweryId = breweryID;
      state.activeBrewery = getById(breweryID, state.breweryList);
    },
    /*
    UPDATE_ACTIVE_BREWERY(state, newBrewery){
      
    },
    */
    INCREMENT_MONEY_LEVEL(state) {
      if (state.moneyLevel == 3) {
        state.moneyLevel = 0;
      } else state.moneyLevel++;
    },
    INCREMENT_NOISE_LEVEL(state) {
      if (state.noiseLevel == 3) {
        state.noiseLevel = 0;
      } else state.noiseLevel++;
    },
    SET_KEYWORD(state, search) {
      state.keywordTerm = search;
    }
  },

})


