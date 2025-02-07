export class Venue {
  id: number;
  name: string;
  imageUrl: string;
  street: string;
  street2: string;
  city: string;
  state:string;
  postalCode: number;
  country: string;

  constructor(
  id: number = 0,
  name: string = '',
  imageUrl: string = '',
  street: string = '',
  street2: string = '',
  city: string = '',
  state:string = '',
  postalCode: number = 0,
  country: string = '',
  ){
    this.id = id;
    this.name = name;
    this.imageUrl = imageUrl;
    this.street = street;
    this.street2 = street2;
    this.city = city;
    this.state = state;
    this.postalCode = postalCode;
    this.country = country;

  }


}
