export class Comedian {
  id: number;
  firstName: string;
  lastName: string;
  imageUrl: string;
  notes: string;


constructor(
  id: number = 0,
  firstName: string = '',
  lastName: string = '',
  imageUrl: string = '',
  notes: string = '',
){
this.id = id;
this.firstName = firstName;
this.lastName = lastName;
this.imageUrl = imageUrl;
this.notes = notes;
}

}
