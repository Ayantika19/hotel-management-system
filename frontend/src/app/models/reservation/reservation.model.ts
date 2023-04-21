import { Discount } from "../discount/discount.model";
import { Hotel } from "../hotel/hotel.model";

export class Reservation {
    bookingId?: any;
    toDate?: string;
    identityProof?: string;
    bookingStatus?: string;
    fromDate?: string;
    countrycode?: any;
    number?: string;
    houseNumber?: string;
    street?: string;
    city?: string;
    pincode?: string;
    discounts?: Discount["companyName"]; 
    hotelDetails?: Hotel["hotelName"];
}