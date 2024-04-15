package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Test
    void testGetUserById() {
        UserRepository mockRepository = mock(UserRepository.class);
        UserService userService = new UserService(mockRepository);

        // Configuration du mock pour retourner un utilisateur spécifique quand findUserById est appelé
        long userId = 1L;
        User expectedUser = new User(userId, "lahmar djihane");
        when(mockRepository.findUserById(userId)).thenReturn(expectedUser);

        // Appel de la méthode à tester
        User result = userService.getUserById(userId);

        // Vérification que le résultat est celui attendu
        assertEquals(expectedUser, result);

        // Vérification que findUserById est appelé avec le bon argument
        verify(mockRepository).findUserById(userId);
    }
}
