package org.babi.Services;

import org.babi.Exceptions.UserNotFoundException;
import org.babi.Models.Auction;
import org.babi.Models.User;
import org.babi.Repositories.AuctionRepository;
import org.babi.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private final UserRepository userRepository;
    private final AuctionRepository auctionRepository;

    public AdminService(UserRepository userRepository, AuctionRepository auctionRepository) {
        this.userRepository = userRepository;
        this.auctionRepository = auctionRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void banUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));
        user.setBanned(true);
        userRepository.save(user);
    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    public List<Auction> getAllAuctions() {
        return auctionRepository.findAll();
    }
}