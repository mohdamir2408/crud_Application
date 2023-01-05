import { Address } from "./address";
import { DS } from "./ds";

export class Employee {
    id: number;
    firstName: string;
    lastName: string;
    emailId: string;
    mobileNo: string;
    addressList: Address[];
    ds: DS ;
    
}
