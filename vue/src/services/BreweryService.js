import axios from "axios";

const http = axios.create({
    baseURL: "http://localhost:8080"
})

export default {

    list() {
        return http.get('/homepage');
    },

    updateBrewery(brewery) {
        return http.put("/brewery/update", brewery)
    },

    deleteBrewery(brewery_id) {
        return http.delete(`/brewery/delete/${brewery_id}`);
    }
}