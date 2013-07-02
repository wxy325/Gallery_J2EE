package org.shinshi.gallery.service.Impl;

import VO.Artistmodel;
import org.shinshi.gallery.dao.ArtistDao;
import org.shinshi.gallery.helper.ParseHelper;
import org.shinshi.gallery.service.ArtistService;

import java.util.List;

/**
 * User: SpringNyan
 * Date: 13-6-17
 * Time: 下午1:34
 */
public class ArtistServiceImpl implements ArtistService<Artistmodel, Integer> {

    private ArtistDao dao;

    public ArtistServiceImpl(ArtistDao dao) {
        this.dao = dao;
    }

    @Override
    public Artistmodel get(Integer id) {
        return this.dao.get(id);
    }

    @Override
    public Integer save(Artistmodel artist) {
        return dao.save(artist);
    }

    @Override
    public void remove(Integer id) {
        dao.delete(id);
    }

    @Override
    public List<Integer> getArtistImg(Integer id) {
        return ParseHelper.postModelToInteger(dao.getPostIdbyArtistId(id));
    }
}
