package by.navigation;



import by.navigation.command.*;

public class CommandFactory {
    public static Command getCommand(String page){

        Commands currentCommand = Commands.valueOf(page.toUpperCase());
    switch(currentCommand){
        case LIST:
            return new ListCommand();
        case IMPORT:
            return new ImportCommand();
        case PAGING:
            return new PagingCommand();
        case SORTING:
            return  new SortingCommand();
        default:
            throw new IllegalArgumentException("Such command doesn't exist");
    }
}

}
