import axios, { AxiosPromise } from "axios"
import { FoodData } from "../interface/FoodData";
//import { useQuery } from "react-query";
import { useQuery } from "@tanstack/react-query";


const API_URL = 'http://localhost:8080'

const fetchData =async (): AxiosPromise<FoodData[]> => {
    const response = await axios.get(API_URL + '/food')
    //console.log("Response: " + response);
    return response;
    
}

export function userFoodData(){

    const query = useQuery({
        queryFn: fetchData,
        queryKey: ['food-data'],
        retry: 2,

    })

    //console.log("oi" + Object.keys(query));
    return {
        ...query,
        data: query.data?.data
    }
}