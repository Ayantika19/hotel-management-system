import { Discount } from "../discount/discount.model";
import { Items } from "../items/items.model";
import { Location } from "../location/location.model";

export class Hotel {
    hotelId?: any;
    hotelName?: any;
    location?: Location["locationName"];
    discounts?: Discount["companyName"];
    gymAvailable?: any;
    swimmingPoolAvailable?: any;
    parkingZoneAvailable?:any;
    totalRooms?: any;
    roomsAvailable?: any;
    carRentAvailable?: any;
    gameZoneAvailable?: any;
    laundryAvailable?: any;
    hotelItems?: Items["charges"];
}