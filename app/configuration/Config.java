package app.configuration;

import app.repository.EventRepositoryImplCollection;
import app.repository.UserRepositoryImplCollection;
import app.service.EventServiceImpl;
import app.service.UserServiceImpl;
import app.service.inputports.EventService;
import app.service.inputports.UserService;
import app.service.outputports.EventRepository;
import app.service.outputports.UserRepository;
import app.ui.CliUserInterface;
import app.view.EventView;
import app.view.UserView;

public class Config {

    public static CliUserInterface getCliUserInterface() {

        UserRepository userRepository = new UserRepositoryImplCollection();
        UserService userService = new UserServiceImpl(userRepository);
        UserView userView = new UserView(userService);

        // NUEVO: Evento
        EventRepository eventRepository = new EventRepositoryImplCollection();
        EventService eventService = new EventServiceImpl(eventRepository);
        EventView eventView = new EventView(eventService);

        return new CliUserInterface(userView, eventView);
    }

}
