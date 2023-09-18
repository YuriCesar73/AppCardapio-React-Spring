import axios, { AxiosPromise } from "axios"
import { FoodData } from "../interface/FoodData";
//import { useQuery } from "react-query";
import { useMutation, useQueryClient } from "@tanstack/react-query";


const API_URL = 'http://localhost:8080'

const postData = async (data: FoodData): AxiosPromise<any> => {
    const response = await axios.post(API_URL + '/food', data)
    //console.log("Response: " + response);
    return response;
    
}

export function useFoodDataMutate(){ 

    const queryClient = useQueryClient();
    const mutate = useMutation({
        mutationFn: postData,
        retry: 2,
        onSuccess: () => {
            queryClient.invalidateQueries(['food-data'])
        }
    })

    return mutate;
}