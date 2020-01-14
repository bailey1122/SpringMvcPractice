package com.sprmvc.web.ch5.data;

        import com.sprmvc.web.ch5.Spitter;
        import org.springframework.stereotype.Repository;

@Repository
public class SpitterRepositoryImpl implements SpitterRepository{

    @Override
    public Spitter save(Spitter spitter) {
        return null;
    }

    @Override
    public Spitter findByUsername(String username) {
        return new Spitter(username + ", ", "no password, ", "no firstName, ", "no lastName.", null);
    }
}
