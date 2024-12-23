import httpClient from "../http-common";

const getAll = () => {
  return httpClient.get("http://localhost:8080/employees/"); //("http://localhost:8080/employees/");
};

const create = (data) => {
  return httpClient.post("http://localhost:8080/employees/", data); //("http://localhost:8080/employees/", data);
};

const get = (id) => {
  return httpClient.get(`http://localhost:8080/employees/${id}`);
};

const update = (data, id) => {
  return httpClient.put(`http://localhost:8080/employees/${id}`, data); //(`http://localhost:8080/employees/${id}`, data);
};

const remove = (id) => {
  return httpClient.delete(`http://localhost:8080/employees/${id}`);
};
export default { getAll, create, get, update, remove };
