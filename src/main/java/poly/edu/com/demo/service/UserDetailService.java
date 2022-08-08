package poly.edu.com.demo.service;


import org.springframework.stereotype.Service;

//@Service
//public class UserDetailService implements UserDetailsService {
////    @Autowired
////    private IUserRepository usersRepository;
////
////    @Override
////    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////        final Users users = usersRepository.findByUsernameLike(username);
////        if (users == null) {
////            throw new UsernameNotFoundException(username);
////        }
////        return User.withUsername(users.getUsername()).password(EncrytedPasswordUtils.encrytePassword(users.getPassword())).authorities(users.getTypeRole().toString()).build();
////    }
//}