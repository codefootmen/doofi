import { api } from "../services/api"

export const GetAllBusinesses = async() => {
    
    const { data } = await api().get(`/business/`)
    return (data[0].value)?data:{};
}

export const GetBusinessesById = async(id = null) => {
    
    if (id === null) return null;
    const { data } = await api().get(`/business/${id}`)
    return (data.value)?data:{};
}