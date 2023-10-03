package com.usuario.service.servicio;

import com.usuario.service.entidades.Usuario;
import com.usuario.service.feign.clients.CarroFeignClient;
import com.usuario.service.feign.clients.MotoFeignClient;
import com.usuario.service.modelos.Carro;
import com.usuario.service.modelos.Moto;
import com.usuario.service.repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private MotoFeignClient motoFeignClient;
    @Autowired
    private CarroFeignClient carroFeignClient;
    public List<Carro> getCarros(int usuarioId){
        List<Carro> carros =restTemplate.getForObject("http://localhost:8002/carro/usuario/"+usuarioId,List.class);
        return carros;
    }

    public List<Moto> getMotos(int usuarioId){
        List<Moto> motos =restTemplate.getForObject("http://localhost:8003/moto/usuario/"+usuarioId,List.class);
        return motos;
    }

    public Carro saveCarro(int usuarioId, Carro carro){
        carro.setUsuarioId(usuarioId);
        Carro carro1=carroFeignClient.save(carro);
        return carro1;
    }

    public Moto saveMoto(int usuarioId, Moto moto){
        moto.setUsuarioId(usuarioId);
        Moto moto1=motoFeignClient.save(moto);
        return moto1;
    }


    public List<Usuario> getAll(){
        return usuarioRepository.findAll();
    }

    public Usuario getUsuarioById(int id){
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario save(Usuario usuario){
        return usuarioRepository.save(usuario);
    }
}
