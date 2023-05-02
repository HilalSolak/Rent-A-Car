package kodlama.io.rentacar.Rules;

import kodlama.io.rentacar.common.constants.Messages;
import kodlama.io.rentacar.core.exceptions.BusinessException;
import kodlama.io.rentacar.repository.ModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModelBusinessRules {
    private ModelRepository modelRepository;

    public void checkIfModelExists(int id) {
        if (!modelRepository.existsById(id)) {
            throw new BusinessException(Messages.Model.NotExists);
        }
    }

}
