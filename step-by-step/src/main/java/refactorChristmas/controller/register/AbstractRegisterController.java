package refactorChristmas.controller.register;

public abstract class AbstractRegisterController<T> implements RegisterController<T> {
    private final ErrorView errorView = new ErrorView();

    @Override
    public T process() {
        try {
            doProcess();
        } catch (IllegalArgumentException e) {
            errorView.printErrorMessage(e.getMessage());
            process();
        }
    }

    abstract T doProcess();
}
