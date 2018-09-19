import { ParentEntity } from './parentEntity.model';

export class UsersModel extends ParentEntity {
    public name: String;
    public lastname: String;
    public username: String;
    public password: String;
    public email: String;
    public role: String;
    public status: String;
}