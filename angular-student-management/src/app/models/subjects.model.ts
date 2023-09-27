import {Sections} from "./sections.model";
import {Result} from "./result.model";

export class Subjects {
  id?:number;
  name?:string;
  code?:string;
  sections?: Sections[];
  result?:Result[];


  constructor(id?: number, name?: string, code?: string, sections?: Sections[], result?: Result[]) {
    this.id = id;
    this.name = name;
    this.code = code;
    this.sections = sections;
    this.result = result;
  }
}
