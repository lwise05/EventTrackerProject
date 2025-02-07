import { Category } from "./category";

export class Comedian {
  id: number;
  firstName: string;
  lastName: string;
  imageUrl: string;
  notes: string;
  category: Category;

constructor(
  id: number = 0,
  firstName: string = '',
  lastName: string = '',
  imageUrl: string = '',
  notes: string = '',
  category: Category = new Category(),
){
this.id = id;
this.firstName = firstName;
this.lastName = lastName;
this.imageUrl = imageUrl;
this.notes = notes;
this.category = category;
}

}
