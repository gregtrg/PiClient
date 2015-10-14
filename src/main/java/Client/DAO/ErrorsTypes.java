package Client.DAO;

/**
 * Created by Рабочий on 05.10.2015.
 */
public enum ErrorsTypes {
    CONNECTION{
        @Override
        public String toString() {
            return "Connection problems";
        }
    }
    ,
    PREPARING{
        @Override
        public String toString() {
            return "Preparing data problems";
        }
    }
    ,
    CLOSEING {
        @Override
        public String toString() {
            return "Closing connection problem";
        }
    }

}
