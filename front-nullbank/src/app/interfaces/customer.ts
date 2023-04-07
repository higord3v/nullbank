export interface ICustomer {
    name: string;
    cpf: string;
    phone: string;
    monthly_income: number;
    street?: string;
    cep?: number;
    address_number?: number;
    relationship?: string;
}
